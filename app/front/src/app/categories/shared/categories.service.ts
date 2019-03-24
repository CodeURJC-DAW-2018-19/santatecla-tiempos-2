import {Injectable} from '../../../../../frontend/daw/node_modules/@angular/core/core';
import {HttpClient} from '../../../../../frontend/daw/node_modules/@angular/common/http';
import {Observable} from '../../../../../frontend/daw/node_modules/rxjs';


@Injectable({providedIn:'root'})
export class CategoriesService{
    public API ='//localhost:8080/api';
    public CAT_API= this.API+'/categories/';

    constructor(private http:HttpClient){

    }

    getAll():Observable<any>{
        return this.http.get(this.API+'/categories/');
    }

    get(id:string){
        return this.http.get(this.CAT_API+'/'+id);
    }

    save(category:any):Observable<any>{
        let result:Observable<object>;
        if(category['href']){
            result=this.http.put(category.href,category);
        }else{
            result=this.http.post(this.CAT_API,category);
        }
        return result;
    }

    remove(href:string){
        return this.http.delete(href);
    }
}

