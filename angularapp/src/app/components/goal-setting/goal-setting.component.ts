import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CardDataService } from 'src/app/services/card-data.service';
import { GoalsettingService } from 'src/app/services/goalsetting.service';
import { TitleService } from 'src/app/services/title.service';
import { IComp } from '../IComp';
import { DataService } from 'src/app/services/data.service';


@Component({
  selector: 'app-goal-setting',
  templateUrl: './goal-setting.component.html',
  styleUrls: ['./goal-setting.component.scss']
})
export class GoalSettingComponent implements OnInit {


  isOpen = false;
  dataList: string[] = ['Swim', 'Eat'];
  goalName: string = '';
  goalIntensity: string = '';
  startDate: string = '';
  duration: number = 0;
  additionalProperties: string = '';
  isFormOpen = false;
  isConfirm = false;
  formValues: any = {};

  swiminput!: number;
  cycleinput!: number;
  yogainput!: number;
  exerciseinput!: number;
  runinput!: number;

  constructor(private goalsettingservice: GoalsettingService, private carddataservice: CardDataService, private datePipe: DatePipe, private router: Router, private dataservice: DataService, private titleService: TitleService) {
    this.titleService.setTitle("Goal Setting")
  }

  setFormValues(button: string): void {
    this.formValues = this.carddataservice.getButtonValues(button);
    this.goalName = this.formValues.name;
    this.additionalProperties = this.formValues.notes;
    this.startDate = this.datePipe.transform(new Date(), 'dd-MM-yyyy') ?? '01-01-1970';
    this.goalIntensity = this.formValues.intensity;
    this.duration = this.formValues.duration;
    this.opencloseConfirm();
  }

  opencloseConfirm() {
    this.isConfirm = !this.isConfirm;
  }

  open() {
    this.isOpen = !this.isOpen;
    console.log('Button clicked!');
  }
  close() {
    this.isOpen = !this.isOpen;
    this.goalName = '';
    this.additionalProperties = '';

  }

  onSubmit() {
    console.log('Form submitted!');
    console.log('Goal Name:', this.goalName);
    console.log('Goal Intensity:', this.goalIntensity);
    console.log('Start Date:', this.startDate);
    console.log('Duration:', this.duration);
    console.log('Additional Properties:', this.additionalProperties);

    let res: string[] = [this.goalName, this.goalIntensity, this.duration.toString(), this.startDate, this.additionalProperties];
    this.goalsettingservice.setGoalData(res);
    this.isOpen = false; //  too Close the form
  }

  onCardClick() {
    this.isFormOpen = true;
  }
  handleCardClick() {
    const card = document.querySelector('.card')!;
    card.classList.add('ripple-effect');

    setTimeout(() => {
      card.classList.remove('ripple-effect');
    }, 800);
  }

  clicktotrack() {
    let dataArray: IComp = { "Swiminput": this.swiminput, "Cycleinput": this.cycleinput, "Yogainput": this.yogainput, "Exerciseinput": this.exerciseinput, "Runinput": this.runinput };
    this.router.navigateByUrl('/tracking');
    this.dataservice.setDataArray(dataArray);
    console.log(dataArray);
  }
  ngOnInit(): void {
  }
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

}

