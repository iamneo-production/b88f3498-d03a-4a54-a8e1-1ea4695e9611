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
import { WorkoutplanComponent } from './components/workoutplan/workoutplan.component';
import { ExercisetrackingComponent } from './components/exercisetracking/exercisetracking.component';

import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { WorkouthistoryComponent } from './components/workouthistory/workouthistory.component';
import { ContainerComponent } from './components/container/container.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './components/registration/registration.component';
import { CustomNutritionRecomendationComponent } from './components/recommendations/custom-nutrition-recomendation/custom-nutrition-recomendation.component';
import { GoalSettingComponent } from './components/goal-setting/goal-setting.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SidenavComponent,
    WorkoutplanComponent,
    ExercisetrackingComponent,
    GoalSettingComponent,
    RecommendationsComponent,
    WorkouthistoryComponent,
    ContainerComponent,
    RegistrationComponent,
    LoginComponent,
    CustomNutritionRecomendationComponent,
    WorkoutplanComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
