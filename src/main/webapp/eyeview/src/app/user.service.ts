import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './model/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl = 'http://localhost:8080/eyeview/user/';
  loginUrl = 'http://localhost:8080/eyeview/login/';
  authenticated = false;
  createUserObservable = new Observable ();

  constructor(private http: HttpClient) {}

  getUsers() {
    return this.http.get<User[]>(this.baseUrl);
  }

  getUserById(id: number) {
    return this.http.get<User>(this.baseUrl + id);
  }

  createUser(user: User) {
    this.createUserObservable = this.http.post(this.baseUrl, user);
    return this.createUserObservable;
  }

  updateUser(user: User) {
    return this.http.put(this.baseUrl + user.id, user);
  }

  deleteUser(id: number) {
    return this.http.delete(this.baseUrl + id);
  }

}
