import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContainerComponent } from './container/container.component';
import { ExercisetrackingComponent } from './exercisetracking/exercisetracking.component';
import { GoalsettingComponent } from './goalsetting/goalsetting.component';
import { HeaderComponent } from './header/header.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { HomeComponent } from './home/home.component';
import { RecommendationsComponent } from './recommendations/recommendations.component';
import { WorkouthistoryComponent } from './workouthistory/workouthistory.component';
import { WorkoutplanComponent } from './workoutplan/workoutplan.component';

@NgModule({
  declarations: [
    AppComponent,
    ContainerComponent,
    ExercisetrackingComponent,
    GoalsettingComponent,
    HeaderComponent,
    SidenavComponent,
    HomeComponent,
    RecommendationsComponent,
    WorkouthistoryComponent,
    WorkoutplanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }