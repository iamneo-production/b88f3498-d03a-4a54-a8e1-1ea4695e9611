import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { WorkoutplanComponent } from './workoutplan/workoutplan.component';
import { GoalsettingComponent} from './goalsetting/goalsetting.component';
import { RecommendationsComponent } from './recommendations/recommendations.component';
import { WorkouthistoryComponent } from './workouthistory/workouthistory.component';
import { ExercisetrackingComponent } from './exercisetracking/exercisetracking.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'workout', component: WorkoutplanComponent},
  { path: 'exertracking', component: ExercisetrackingComponent},
  { path: 'goalsetting', component: GoalsettingComponent},
  { path: 'recommendations', component: RecommendationsComponent},
  { path: 'history', component: WorkouthistoryComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
