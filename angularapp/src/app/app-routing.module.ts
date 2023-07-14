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
import { ProfileComponent } from './components/profile/profile.component';
import { guardGuard } from './services/guard.guard';
import { CustomNutritionRecomendationComponent } from './components/recommendations/custom-nutrition-recomendation/custom-nutrition-recomendation.component';
import { ListworksComponent } from './components/listworks/listworks.component';
import { WorksComponent } from './components/works/works.component';
import { GoalhomeComponent } from './components/goalhome/goalhome.component';

const routes: Routes = [
  {path:'', redirectTo: 'register', pathMatch: 'full'},
  {path:'register', component: RegistrationComponent},
  {path:'login', component: LoginComponent},
  { path: '',canActivate: [guardGuard],
  children:[
    { path: 'home', component: HomeComponent },
    { path: 'workout', component: WorkoutplanComponent},
    { path: 'goalhome', component: GoalhomeComponent},
    { path: 'goalsetting', component: GoalSettingComponent},
    { path: 'recommendations', component: RecommendationsComponent},
    { path: 'history', component: WorkouthistoryComponent},
    {path: 'customRecommendation', component: CustomNutritionRecomendationComponent},
    { path: 'exertracking', component: ExercisetrackingComponent},
    { path: 'exertracking/goaltracking', component: GoaltrackingComponent},
    { path: 'exertracking/heightweighttracking', component: HtwtcompComponent},
    { path: 'profile', component: ProfileComponent},
    { path: 'exertracking/workoutstracking', component: ListworksComponent},
    { path: 'exertracking/workoutstracking/:id', component: WorksComponent},
  ] 
},
{ path: '**', component: ErrorPageComponent }
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
