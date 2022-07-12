import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

import { History } from '../history/history'

import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  calculate(first: number, second: number, operand: string): Observable<number> {
    return this.http.post<number>('http://localhost:8080/calculate/' + operand, {'first': first, 'second': second})
  }

  history(): Observable<History[]> {
  return this.http.get<History[]>('http://localhost:8080/calculate/history')}
}
