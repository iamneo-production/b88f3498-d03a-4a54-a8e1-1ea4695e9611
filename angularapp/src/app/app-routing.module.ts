import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WorkoutplanComponent } from './components/workoutplan/workoutplan.component';
import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { WorkouthistoryComponent } from './components/workouthistory/workouthistory.component';
import { ExercisetrackingComponent } from './components/exercisetracking/exercisetracking.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { GoalSettingComponent } from './components/goal-setting/goal-setting.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { GoaltrackingComponent } from './components/goaltracking/goaltracking.component';
import { DatetrackingComponent } from './components/datetracking/datetracking.component';
import { HtwtcompComponent } from './components/htwtcomp/htwtcomp.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: '', redirectTo: 'register', pathMatch: 'full' },
  {path:'register', component: RegistrationComponent},
  {path:'login', component: LoginComponent},
  { path: 'home', component: HomeComponent },
  {path: 'login', component: LoginComponent},
  { path: 'workout', component: WorkoutplanComponent},
  { path: 'exertracking', component: ExercisetrackingComponent},
  { path: 'goalsetting', component: GoalSettingComponent},
  { path: 'recommendations', component: RecommendationsComponent},
  { path: 'history', component: WorkouthistoryComponent},
  { path: 'exertracking/goaltracking', component: GoaltrackingComponent},
  { path: 'exertracking/datetracking', component: DatetrackingComponent},
  { path: 'exertracking/heightweighttracking', component: HtwtcompComponent},
  { path: '**', component: ErrorPageComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
