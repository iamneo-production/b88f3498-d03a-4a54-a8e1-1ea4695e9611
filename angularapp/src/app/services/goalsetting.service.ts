import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GoalsettingService {

  private goalData: any = null;
  constructor() { }
  setGoalData(data: any): void {  //storing the string array hereeuh
    this.goalData = data;
  }

  getGoalData(): any {
    return this.goalData;
  }
}
