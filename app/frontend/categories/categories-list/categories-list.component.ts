import {Component,OnInit}from '../../daw/node_modules/@angular/core/core';
import {CategoriesService}from '../shared/categories.service';


@Component({
    selector:'categories-list',
    templateUrl:'categories.component.html',
    styleUrls:['categories.component.css']
})

export class CategoriesListComponent implements OnInit{
    categories: Array<any>;
    constructor(private catSev:CategoriesService){}
    ngOnInit(){
        this.catSev.getAll().susbscribe(data=>{
            this.categories=data;
        });
    }

}