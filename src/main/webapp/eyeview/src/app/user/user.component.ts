import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../model/user.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  users: User[];
  searchText: String;
  searchForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.userService.createUserObservable.subscribe( data => {
      //this.users.push(data);
    });
    this.searchForm = this.formBuilder.group({
      'searchText' : []
    });
    this.userService.getUsers()
      .subscribe( data => {
        this.users = data;
        this.searchText = '';
      });
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user.id)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      });
  }

  editUser(user: User): void {
    localStorage.removeItem('editUserId');
    localStorage.setItem('editUserId', user.id.toString());
    this.router.navigate(['edit-user']);
  }

  addUser(user: User) {
    this.users.push(user);
  }

}
