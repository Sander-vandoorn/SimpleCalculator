import { Component, OnInit } from '@angular/core'
import { HttpService } from '../shared/http.service'
import { FormBuilder } from '@angular/forms'
import { Output, EventEmitter } from '@angular/core';

import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-calculator-form',
  templateUrl: './calculator-form.component.html',
  styleUrls: ['./calculator-form.component.css']
})
export class CalculatorFormComponent implements OnInit {

  result: number = 0
  inputform = this.formBuilder.group({
    first: 0,
    second: 0,
    operand: 'add'
  })
  @Output() updateEvent = new EventEmitter<boolean>;

  constructor(
    private service: HttpService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {

  }

  calculate(first: number, second: number, operand: string): void {
    this.service.calculate(first, second, operand).subscribe(res => {
      this.result = res
      this.updateEvent.emit(true)
    })
  }

  onSubmit(): void {
    let firstNumber: number =this.inputform.value.first as number
    let secondNumber: number = this.inputform.value.second as number
    let operand: string = this.inputform.value.operand as string
    this.calculate(firstNumber, secondNumber, operand)
  }

}
