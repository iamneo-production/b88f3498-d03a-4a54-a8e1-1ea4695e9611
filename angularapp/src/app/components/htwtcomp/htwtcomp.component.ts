import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Chart, registerables } from 'chart.js';
import { TitleService } from 'src/app/services/title.service';
import { TokenService } from 'src/app/services/token.service';
import { UserAuthService } from 'src/app/services/user-auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-htwtcomp',
  templateUrl: './htwtcomp.component.html',
  styleUrls: ['./htwtcomp.component.scss']
})
export class HtwtcompComponent implements OnInit {
  entries: any[] = [];
  baseUrl: string = this.userService.baseUrl;
  date: string = new Date().toISOString().substr(0, 10); // Initialize with today's date
  // height: number = 0;
  calories!: number;
  weight!: number;
  height!: number;
  chart: Chart | undefined;
  userId!: number;
  
  constructor(private userService: UserService, private http: HttpClient, private userAuthService: UserAuthService, private tokenService: TokenService, private titleService:TitleService) {
    this.titleService.setTitle("Height Weight Tracker");
    this.userService.userSubject.subscribe({
      next: user => { this.userId = user.id; }
    })
  }
  ngOnInit(): void {
    Chart.register(...registerables);
    

    this.http.get(`${this.baseUrl}/api/v1/tracking/${this.userId}`, this.tokenService.getHeader()).subscribe({
      next: (response: any) => { this.entries = response; }
    })
  }



  addEntry() {
    this.calories = this.userService.getUserCalorie(this.weight);
    console.log(this.calories);
    if (this.date && this.weight && this.height) {

      const entry = {
        date: this.date,
        userId: this.userId,
        calories: this.calories,
        weight: this.weight,
        height: this.height
      };
      this.entries.push(entry);
      this.date = '';
      this.calories = 0;
      this.weight = 0;
      this.height = 0;




      this.http.post(`${this.baseUrl}/api/v1/tracking`, entry, this.tokenService.getHeader()).subscribe({
        next: (response: any) => {
          console.log('Data sent successfully:', response);

        },
        error: error => {
          console.error('Error while sending data:', error);
        }
      });
    }
  }

  updateChart() {
    const labels = this.entries.map(entry => entry.date);
    const calories = this.entries.map(entry => entry.calorie);
    const weights = this.entries.map(entry => entry.weight);
    const heights = this.entries.map(entry => entry.height);

    if (this.chart) {
      this.chart.data.labels = labels;
      this.chart.data.datasets[0].data = calories;
      this.chart.data.datasets[1].data = weights;
      this.chart.data.datasets[2].data = heights;
      this.chart.update();
    } else {
      const ctx = document.getElementById('chart') as HTMLCanvasElement;
      this.chart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: labels,
          datasets: [
            {
              label: 'Calorie (cal)',
              data: calories,
              borderColor: 'rgba(75, 192, 192, 1)',
              fill: false
            },
            {
              label: 'Weight (kg)',
              data: weights,
              borderColor: 'rgba(255, 99, 132, 1)',
              fill: false
            },
            {
              label: 'Height (cm)',
              data: heights,
              borderColor: 'rgba(200, 99, 132, 1)',
              fill: false
            }
          ]
        },
        options: {
          responsive: true,
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
