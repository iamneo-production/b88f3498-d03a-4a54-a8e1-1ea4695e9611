import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Chart, registerables, scales } from 'chart.js';

@Component({
  selector: 'app-htwtcomp',
  templateUrl: './htwtcomp.component.html',
  styleUrls: ['./htwtcomp.component.scss']
})
export class HtwtcompComponent implements OnInit {
  entries: any[] = [];
  date: string = new Date().toISOString().substr(0, 10); // Initialize with today's date
  // height: number = 0;
  calorie!: number;
  weight!: number;
  height!: number;
  chart: Chart | undefined;
  constructor(private userService: UserService) { }
  ngOnInit(): void {
    Chart.register(...registerables);
  }

  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

  addEntry() {
    this.calorie = this.userService.getUserCalorie(this.weight);
    console.log(this.calorie);
    if (this.date && this.weight && this.height) {
      const entry = {
        date: this.date,
        calorie: this.calorie,
        weight: this.weight,
        height: this.height
      };
      this.entries.push(entry);
      this.date = '';
      this.weight = 0;
      this.height = 0;
      this.updateChart();
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
