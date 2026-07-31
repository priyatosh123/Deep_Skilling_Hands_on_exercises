import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HighlightDirective } from '../../directives/highlight';
import { EnrollmentService } from '../../services/enrollment';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, HighlightDirective, CreditLabelPipe],
  template: `
    <div [appHighlight]="course?.gradeStatus === 'passed' ? 'lightgreen' : ''">
      <h3>{{ course?.name }}</h3>
      <p>Code: {{ course?.code }}</p>
      <p>Credits: {{ course?.credits | creditLabel }}</p>
      <button (click)="onEnroll()">Enroll</button>
    </div>
  `
})
export class CourseCardComponent implements OnChanges {
  @Input() course: any;
  @Output() enrollRequested = new EventEmitter<number>();

  constructor(private enrollmentService: EnrollmentService) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('Previous value:', changes['course'].previousValue);
      console.log('Current value:', changes['course'].currentValue);
    }
  }

  onEnroll(): void {
    if (this.course?.id) {
      this.enrollRequested.emit(this.course.id);
    }
  }
}