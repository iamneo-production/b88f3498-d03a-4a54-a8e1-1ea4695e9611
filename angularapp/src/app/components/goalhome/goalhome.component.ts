import { Component, OnInit } from '@angular/core';

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

}


