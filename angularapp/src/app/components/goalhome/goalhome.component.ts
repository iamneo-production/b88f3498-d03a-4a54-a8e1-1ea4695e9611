import { Component, ElementRef, HostListener, OnInit, ViewChild } from '@angular/core';

interface Task {
  name: string;
  duration: string;
  time: string;
  date: string;
}

@Component({
  selector: 'app-goalhome',
  templateUrl: './goalhome.component.html',
  styleUrls: ['./goalhome.component.scss']
})
export class GoalhomeComponent implements OnInit{

  ngOnInit(): void {
  }
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

  dropdownOpen: boolean = false;
  tasks: Task[] = [
    { name: 'Walking',duration: '30 minutes', time: '6.30 AM', date: '2022-07-18' },
    { name: 'Go to gym everyday',duration: '60 minutes', time: '5:45 PM', date: '2023-07-20' },
    { name: 'Jogging', duration: '1 hour 15 minutes',time: '6.00 AM', date: '2023-06-19' },
    
    { name: 'Yoga', duration: '40 minutes',time: '11.00 AM', date: '2023-07-20' },
    { name: 'Water Aerobics', duration: '40 minutes',time: '4.30 PM', date: '2023-07-21' },
    { name: 'Swimming', duration: '30 minutes',time: '10.00 AM', date: '2022-06-20' },
    { name: 'Exercise', duration: '45 minutes',time: '3.00 PM', date: '2023-05-20' },
    { name: 'Cycling', duration: '60 minutes',time: '4.00 PM', date: '2022-06-21' },
    
  ];

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
      const taskDate = new Date(task.date);
      return taskDate >= lastMonth;
    });

    this.dropdownOpen = false; 
  }

  showLastWeekTasks() {
    const today = new Date();
    const lastWeek = new Date(today.getFullYear(), today.getMonth(), today.getDate() - 7);

    this.filteredTasks = this.tasks.filter(task => {
      const taskDate = new Date(task.date);
      return taskDate >= lastWeek;
    });

    this.dropdownOpen = false;
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

  






