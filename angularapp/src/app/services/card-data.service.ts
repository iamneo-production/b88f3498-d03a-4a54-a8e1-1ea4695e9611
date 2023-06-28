import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CardDataService {

 defaultValues: any = {
    card1: {
      name: 'Swimming',
      date: '10-08-2023',
      notes:'Dive into swimming for a full-body workout that boosts cardiovascular health and endurance.',
      intensity:'low',
      duration: 1
    },
    card2: {
      name: 'Cycling',
      date: '10-08-2023',
      notes: 'aa',
      intensity:'low',
      duration: 1
    },
    card3: {
      name: 'yoga',
      date: '10-08-2023',
      notes: 'aa',
      intensity:'low',
      duration: 1
    },
    card4: {
      name: 'exercise',
      date: '10-08-2023',
      notes: 'aa',
      intensity:'low',
      duration: 1
    },
    card5: {
      name: 'run',
      date: '',
      notes: 'aa',
      intensity:'low',
      duration: 1
    }
  };

  constructor() { 
    
  }

  getButtonValues(card: string): any {
    return this.defaultValues[card];

  }
}
