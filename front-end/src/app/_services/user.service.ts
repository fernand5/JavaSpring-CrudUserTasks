import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../_models/user';
import {DatePipe} from '@angular/common';


@Injectable()
export class UserService {
  baseUrl = '';
  productToUpdate = null;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080';
  }

  @Output() reload: EventEmitter<any> = new EventEmitter();


  getAll() {
    return this.http.get<any>(this.baseUrl + '/user');
  }

  create(user: User) {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post<any>(this.baseUrl + '/user', user, {headers: headers});
  }

  delete(id: number) {
    return this.http.delete<any>(this.baseUrl + '/user/' + id);
  }

  getById(id: number) {
    return this.http.get<any>(this.baseUrl + '/user/' + id);
  }

  update(id: number, user: User) {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    const datePipe = new DatePipe('en-US');
    user.birthDate = datePipe.transform(user.birthDate, 'yyyy-MM-dd');
    user.id = null;
    user.tasks = null;
    return this.http.put<any>(this.baseUrl + '/user/' + id, user, {headers: headers});
  }
  addTask(id: number, idTask: number){
    return this.http.put<any>(this.baseUrl + '/user/' + id + '/addTask/' + idTask, {});
  }
  reloadData() {
    this.reload.emit();
  }

}
