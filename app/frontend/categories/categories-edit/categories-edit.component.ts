import {Component,OnDestroy,OnInit} from '../../daw/node_modules/@angular/core';
import {Subscription} from '../../daw/node_modules/rxjs';
import {ActivatedRoute,Router} from '../../daw/node_modules/@angular/router';
import {CategoriesService} from "../shared/categories.service";
import {NgForm} from '../../daw/node_modules/@angular/forms';

@Component({
    selector:'categories-edit',
    templateUrl:'./categories-edit.component.html',
    styleUrls:['./categories-edit.component.css']
})

export class CategoriesEditComponent implements OnInit,OnDestroy {
    category: any = {};
    sub: Subscription;

    constructor(private route: ActivatedRoute, private router: Router, private catService: CategoriesService) {
    }

    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
            const id = params['id'];
            if (id) {
                this.catService.get(id).subscribe((category: any) => {
                    if (category) {
                        this.category = category;
                        this.category.href = category._links.self.href;
                    }
                });
            }
        });
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    gotoList(){
        this.router.navigate(['/']);
    }

    save(form:NgForm){
        this.catService.save(form).subscribe(result=> {
            this.gotoList();
        },error => console.error(error));
        }

    remove(href){
        this.catService.remove(href).subscribe(result=> {
            this.gotoList();
        },error => console.error(error));
        }

}

