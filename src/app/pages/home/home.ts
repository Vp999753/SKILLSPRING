import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseListComponent } from '../../components/course-list/course-list.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, CourseListComponent], // ✅ THIS IS THE FIX
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class HomeComponent {}
