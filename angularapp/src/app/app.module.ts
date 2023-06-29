import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { ExercisetrackingComponent } from './components/exercisetracking/exercisetracking.component';

import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { ContainerComponent } from './components/container/container.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './components/registration/registration.component';
import { CustomNutritionRecomendationComponent } from './components/recommendations/custom-nutrition-recomendation/custom-nutrition-recomendation.component';
import { DatePipe } from '@angular/common';
import { WorkouthistoryComponent } from './components/workouthistory/workouthistory.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTableModule } from '@angular/material/table';
import { WorkoutplanComponent } from './components/workoutplan/workoutplan.component';
import { HttpClientModule } from '@angular/common/http';
import { GoalSettingComponent } from './components/goal-setting/goal-setting.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SidenavComponent,
    ExercisetrackingComponent,
    RecommendationsComponent,
    WorkouthistoryComponent,
    ContainerComponent,
    RegistrationComponent,
    LoginComponent,
    CustomNutritionRecomendationComponent,
    WorkoutplanComponent,
    GoalSettingComponent  

  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatDividerModule,
    MatIconModule,
    MatListModule,
    MatSidenavModule,
    MatToolbarModule,
    MatMenuModule,
    MatTableModule,
    MatDialogModule,
    HttpClientModule

  ],
  providers: [DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule {}
