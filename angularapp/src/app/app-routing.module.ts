import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { WorkoutplanComponent } from './components/workoutplan/workoutplan.component';
import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { WorkouthistoryComponent } from './components/workouthistory/workouthistory.component';
import { ExercisetrackingComponent } from './components/exercisetracking/exercisetracking.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { GoalSettingComponent } from './components/goal-setting/goal-setting.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'workout', component: WorkoutplanComponent},
  { path: 'exertracking', component: ExercisetrackingComponent},
  { path: 'goalsetting', component: GoalSettingComponent},
  { path: 'recommendations', component: RecommendationsComponent},
  { path: 'history', component: WorkouthistoryComponent},
  { path: '**', component: ErrorPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
