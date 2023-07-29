import { Component, OnInit } from '@angular/core';
import { TitleService } from 'src/app/services/title.service';
import { IComp } from 'src/app/interfaces/IComp';
import {Chart, registerables} from 'chart.js';
import { DataService } from 'src/app/services/data.service';

Chart.register(...registerables);

@Component({
  selector: 'app-goaltracking',
  templateUrl: './goaltracking.component.html',
  styleUrls: ['./goaltracking.component.scss']
})
export class GoaltrackingComponent implements OnInit{

  myCha:any;

  dataArray:IComp[] = this.dataservice.getDataArray();

  constructor(private titleService:TitleService, private dataservice: DataService) {
    this.titleService.setTitle("Goals Tracker");
   }
  ngOnInit(): void {
      
  }

  
  displaychart(){
    for(let val of this.dataArray){
    this.myCha = new Chart("myChart", {
        type: 'pie',
        data: {
            labels: ['Swimming', 'Cycling', 'Yoga', 'Exercise', 'Running'],
            datasets: [{
                label: '# no. of minutes',
                data: [val.Swiminput, val.Cycleinput, val.Yogainput, val.Exerciseinput, val.Runinput],
                backgroundColor: [
                    '#ADD8E6',
                    '#90EE90',
                    '#FFB6C1',
                    '#FFFFE0',
                    '#E6E6FA'
                    
                ],
                borderColor: [
                    '#000080',
                    '#006400',
                    '#FF69B4',
                    '#CCCC00',
                    '#9370DB'
                    
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

  }
 
}
}
