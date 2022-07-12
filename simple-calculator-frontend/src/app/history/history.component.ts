import { Component, OnInit, OnChanges, Input, SimpleChanges } from '@angular/core';
import { HttpService } from '../shared/http.service'
import { History } from './history'

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit, OnChanges {

  history: History[] = []
  @Input() update = false

  constructor(
    private service: HttpService
  ) { }

  ngOnInit(): void {
    this.getHistory()
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.getHistory()
  }

  getHistory() {
    this.service.history().subscribe(res => (this.history = res))
  }

}
