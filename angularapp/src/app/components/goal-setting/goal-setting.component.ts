import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IComp } from 'src/app/interfaces/IComp';
import { CardDataService } from 'src/app/services/card-data.service';
import { DataService } from 'src/app/services/data.service';
import { GoalsettingService } from 'src/app/services/goalsetting.service';
import { TitleService } from 'src/app/services/title.service';

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

  onSubmit(status:string) {
    const request = {name:'',intensity:'',date:'',duration:0,notes:'',status:''};

    console.log(this.startDate);
    if (this.isReverseDateFormat(this.startDate)) {
      const rightDateFormat = this.convertToRightDateFormat(this.startDate);
      this.startDate = rightDateFormat;
      this.opencloseConfirm();
    }
    console.log(this.startDate);

    console.log('Form submitted!');
    request['name']= this.goalName;
    request['intensity']= this.goalIntensity;
    request['date']= this.startDate;
    request['duration']= this.duration;
    request['notes']= this.additionalProperties;
    request['status']=status;

    console.log(request);
    this.goalsettingservice.setGoalData(request);
    this.isOpen = false; //  too Close the form
  }

  isReverseDateFormat(input: string): boolean {
    const reverseDateFormatRegex = /^\d{2}-\d{2}-\d{4}$/;
    return reverseDateFormatRegex.test(input);
  }

  convertToRightDateFormat(input: string): string {
    const parts = input.split('-');
    if (parts.length !== 3 || parts[0].length !== 2 || parts[1].length !== 2 || parts[2].length !== 4) {
      throw new Error('Invalid reverse date format');
    }

    return `${parts[2]}-${parts[1]}-${parts[0]}`;
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
    this.router.navigateByUrl('exertracking/goaltracking');
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

