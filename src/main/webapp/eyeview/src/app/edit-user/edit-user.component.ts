import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit {

  user: User;
  editForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private userService: UserService) { }

  ngOnInit() {
    let userId = localStorage.getItem('editUserId');
    if (!userId) {
      alert('invalid action');
      return;
    }

    this.editForm = this.formBuilder.group({
      'id' : [],
      'name' : [ '' , [Validators.required, Validators.minLength(3)]],
      'age' : [ '' , [Validators.required, Validators.min(1)]],
      'createdDate' : []
    });

    this.userService.getUserById(+userId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.userService.updateUser(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['users']);
        },
        error => {
          alert(error);
        });
  }


}
