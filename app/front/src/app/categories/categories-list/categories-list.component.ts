import {Component,OnInit}from 'node_modules/@angular/core';
import {CategoriesService}from '../shared/categories.service';


@Component({
    selector:'categories-list',
    templateUrl:'./categories-list.component.html',
    styleUrls:['./categories-list.component.css'],

})

export class CategoriesListComponent implements OnInit{
    categories: Array<any>;
    constructor(private catSev:CategoriesService){}
    ngOnInit(){
        this.catSev.getAll().subscribe(data=>{
            this.categories=data;
        });
    }

}
