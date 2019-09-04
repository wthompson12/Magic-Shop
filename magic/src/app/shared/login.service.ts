import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Human } from './human'

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  url = 'http://localhost:8080/MagicShop';
  private human: Human;

  constructor(private http: HttpClient) { }

  public login(human: Human){
    if(human.username && human.password){
      const body = JSON.stringify(human);
      return this.http.post(this.url + "/login/", body, {headers: this.headers, withCredentials: true}).pipe(
        map( resp => {
          const user: Human = resp as Human;
          if (user) {
            this.human = user;
          }
          return user;
        })
      );
    }
    else{
      return this.http.get(this.url+"/login/", {withCredentials: true}).pipe(map(resp => resp as Human))
    }
  }

  getHuman(): Human{
    return this.human;
  }
}
