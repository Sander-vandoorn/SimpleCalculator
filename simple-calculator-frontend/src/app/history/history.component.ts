import { Component, OnInit } from '@angular/core';
import { HttpService } from '../shared/http.service'
import { History } from './history'

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  history: History[] = []

  constructor(
    private service: HttpService
  ) { }

  ngOnInit(): void {
    this.getHistory()
  }

  getHistory() {
    this.service.history().subscribe(res => (this.history = res))
  }

}
