import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { UserComponent } from '../user/user.component';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private userService: UserService) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      'id' : [],
      'name' : [ '' , [Validators.required, Validators.minLength(3)]],
      'age' : [ '' , [Validators.required, Validators.min(1)]],
      'createdDate' : []
    });
  }

  onSubmit() {
    this.userService.createUser(this.addForm.value)
      .subscribe( data => {
        location.reload();
      });
  }

}
