import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { WorkoutplanComponent } from './components/workoutplan/workoutplan.component';
import { GoalsettingComponent} from './components/goalsetting/goalsetting.component';
import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { WorkouthistoryComponent } from './components/workouthistory/workouthistory.component';
import { ExercisetrackingComponent } from './components/exercisetracking/exercisetracking.component';
import { AppComponent } from './app.component';


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
