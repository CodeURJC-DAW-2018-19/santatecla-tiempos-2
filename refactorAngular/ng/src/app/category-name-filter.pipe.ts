import { Pipe, PipeTransform } from '@angular/core';
import {Category} from "./category.service";

@Pipe({
  name: 'categoryNameFilter'
})
export class CategoryNameFilterPipe implements PipeTransform {

  transform(categories:Category[], nameCategory: string): Category[] {
   if(nameCategory==null || nameCategory ===""){
     return categories;
   }
   return categories.filter(c=>c.nameCategory.includes(nameCategory)|| c.nameCategory.includes(nameCategory));
  }

}
