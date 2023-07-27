import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, HostListener, OnInit, ViewChild } from '@angular/core';
import { GoalsettingService } from 'src/app/services/goalsetting.service';
import { TokenService } from 'src/app/services/token.service';
import { environment } from 'src/environment';

interface Task {
  id: number;
  name: string;
  notes: string;
  intensity: string;
  date: any;
  duration: number;
  status: string;
}

@Component({
  selector: 'app-goalhome',
  templateUrl: './goalhome.component.html',
  styleUrls: ['./goalhome.component.scss']
})
export class GoalhomeComponent implements OnInit{

  constructor(private goalService:GoalsettingService,private http:HttpClient, private tokenService: TokenService){}

  ngOnInit(): void {
    this.getTasks();
  }
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

  dropdownOpen: boolean = false;
  tasks: Task[] = [];

  filteredTasks: Task[] = this.tasks;

  toggleDropdown() {
    this.dropdownOpen = !this.dropdownOpen;
  }

  onKeyDown(event: KeyboardEvent) {
    if (event.key === "ArrowDown") {
      event.preventDefault();
      this.focusNextOption();
    }
  }

  focusNextOption() {
    const dropdownLinks = Array.from(document.querySelectorAll<HTMLElement>(".dropdown-content a"));
    const currentLink = document.activeElement as HTMLElement;

    const currentIndex = dropdownLinks.indexOf(currentLink);
    if (currentIndex >= 0 && currentIndex + 1 < dropdownLinks.length) {
      const nextLink = dropdownLinks[currentIndex + 1];
      currentLink.blur();
      nextLink.focus();
    }
  }
  showAllTasks() {
    this.filteredTasks = [...this.tasks];
    this.dropdownOpen = false;
  }

  showLastMonthTasks() {
    const today = new Date();
    const lastMonth = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
  
    this.filteredTasks = this.tasks.filter(task => {
      const taskDate = new Date(task.date.split('-').reverse().join('-'));
      return taskDate >= lastMonth;
    });
  
    this.dropdownOpen = false;
  }
  
  showLastWeekTasks() {
    const today = new Date();
    const lastWeek = new Date(today.getFullYear(), today.getMonth(), today.getDate() - 7);
  
    this.filteredTasks = this.tasks.filter(task => {
      const taskDate = new Date(task.date.split('-').reverse().join('-'));
      return taskDate >= lastWeek;
    });
  
    this.dropdownOpen = false;
  }
  
  
  getTasks(){
    
    
    const defaultStatus = 'inprogress'; 
    const url = `${environment.baseUrl}/goal/all?status=${defaultStatus}`;
    
    this.http.get<any>(url, this.tokenService.getHeader()).subscribe(
      response => {
      console.log(response);
      response = this.formatDate(response);
      console.log(response);
      this.tasks = response;
      this.showAllTasks();
    },
   
  );   
      
    
  }

formatDate(exercises: Task[]): Task[] {
  for (const exercise of exercises) {
    const [year, month, day] = exercise.date.split('-');
    const formattedDate = `${this.padZero(day)}-${this.padZero(month)}-${year}`;
    exercise.date = formattedDate;
  }
  return exercises;
}
padZero(value: number): string {
  return value.toString().padStart(2, '0');
}
  

    closeDropdown() {
      this.dropdownOpen = false;
    }

    @ViewChild('dropdownButton') dropdownButton!: ElementRef;

    @HostListener('document:click', ['$event'])
    onDocumentClick(event: MouseEvent) {
      if (
        this.dropdownButton.nativeElement &&
        !this.dropdownButton.nativeElement.contains(event.target)
      ) {
        this.closeDropdown();
    }
    }
  
  }
