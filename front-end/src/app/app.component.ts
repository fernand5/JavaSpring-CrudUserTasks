import {Component, OnInit} from '@angular/core';
import {UserService} from './_services/user.service';
import {TaskService} from './_services/task.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  users: any;
  model: any = {};
  modelTask: any = {};
  modelUserTask: any = {};
  dependencies: any;
  profiles: any;
  tasks: any;
  toEdit: number;

  constructor(
    private userService: UserService,
    private taskService: TaskService
  ) {
    this.toEdit = 0;
    this.tasks = [
      {'name': 'Administrador', 'value': 'ADMINISTRADOR'},
      {'name': 'Consulta', 'value': 'CONSULTA'},
      {'name': 'Operador', 'value': 'OPERADOR'},
    ];

    this.profiles = [
      {'name': 'Administrador', 'value': 'ADMINISTRADOR'},
      {'name': 'Consulta', 'value': 'CONSULTA'},
      {'name': 'Operador', 'value': 'OPERADOR'},
    ];
    console.log(this.profiles);

    this.dependencies = [
      {'name': 'Consultoria', 'value': 'CONSULTORIA'},
      {'name': 'Fabrica', 'value': 'FABRICA'},
      {'name': 'Desarrollo', 'value': 'DESARROLLO'},
    ];

    this.reloadUsers();
  }


  ngOnInit() {

    this.userService.reload.subscribe(data => {
      this.reloadUsers();
    });
  }

  reloadUsers() {
    this.userService.getAll().subscribe(data => {
      console.log(data);
      this.users = data;
      this.taskService.getAll().subscribe(dataTask => {
        this.tasks = dataTask;
        console.log(dataTask);
      });
    });
  }

  onSubmit() {
    console.log(this.toEdit);
    if(this.toEdit === 0) {
      this.userService.create(this.model).subscribe(data => {
          this.userService.reloadData();
        },
        error => {
          this.userService.reloadData();
          console.log(error);
        });
    } else {
      this.userService.update(this.toEdit, this.model).subscribe(data => {
          this.toEdit = 0;
          this.userService.reloadData();
        },
        error => {
          this.toEdit = 0;
          this.userService.reloadData();
          console.log(error);
        });
    }

  }

  onSubmitTask() {
    this.taskService.create(this.modelTask).subscribe(
      data => {
      console.log(data);
    }, error => {
      this.userService.reloadData();
      console.log(error);
    });
  }

  delete(id: number) {
    this.userService.delete(id).subscribe(
      data => {
        this.userService.reloadData();
      },
      error => {
        this.userService.reloadData();
        console.log(error);
      }
    );
  }

  update(id: number) {
    this.toEdit = id;
    this.userService.getById(id).subscribe(data => {
      this.model = data;
    });
  }

  onSubmitAddTask() {

    console.log(this.modelUserTask);
    this.userService.addTask(this.modelUserTask.userTask, this.modelUserTask.taskUser).subscribe(
      data => {
        this.userService.reloadData();
      },
      error => {
        this.userService.reloadData();
        console.log(error);
      });

  }
}
