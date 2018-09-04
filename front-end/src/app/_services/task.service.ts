import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../_models/user';
import {Task} from '../_models/task';


@Injectable()
export class TaskService {
  baseUrl = '';
  productToUpdate = null;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080';
  }


  getAll() {
    return this.http.get<any>(this.baseUrl + '/task');
  }

  create(task: Task) {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post<any>(this.baseUrl + '/task', task, {headers: headers});
  }

  delete(id: number) {
    return this.http.delete<any>(this.baseUrl + '/task/' + id);
  }

  getById(id: number) {
    return this.http.get<any>(this.baseUrl + '/task/' + id);
  }

  update(id: number, task: Task) {
    return this.http.put<any>(this.baseUrl + '/task/' + id, task);
  }
}
