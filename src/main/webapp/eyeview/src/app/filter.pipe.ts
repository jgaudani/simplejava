import { Pipe, PipeTransform } from '@angular/core';
import { User } from './model/user.model';
@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
  transform(users: User[], searchText: string): User[] {
    if (!users) {
        return [];
    }
    if (!searchText) {
        return users;
    }
searchText = searchText.toLowerCase();
return users.filter( u => {
      console.log(u);
      return u.name.toLowerCase().includes(searchText);
    });
   }
}
