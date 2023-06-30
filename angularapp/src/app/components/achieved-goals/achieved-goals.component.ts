import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-achieved-goals',
  templateUrl: './achieved-goals.component.html',
  styleUrls: ['./achieved-goals.component.scss']
})
export class AchievedGoalsComponent implements OnInit{
  ngOnInit(): void {
  }
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

  

  achievedGoals: any[] = [
    { goal: 'Goal 1', date: '2023-05-15', duration: '30 minutes', result: 'Completed' },
    { goal: 'Goal 2', date: '2023-05-20', duration: '45 minutes', result: 'Completed' },
    { goal: 'Goal 3', date: '2023-05-25', duration: '60 minutes', result: 'Completed' },
    { goal: 'Goal 4', date: '2023-05-30', duration: '40 minutes', result: 'Completed' }
  ];

}
