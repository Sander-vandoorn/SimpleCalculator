import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';


import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CalculatorFormService {

  constructor(private http: HttpClient) { }

  calculate(first: number, second: number, operand: string): Observable<number> {
    return this.http.post<number>('http://localhost:8080/calculate/' + operand, {'first': first, 'second': second})
  }
}
