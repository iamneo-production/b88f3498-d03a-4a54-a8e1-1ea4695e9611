import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AchievedGoalsComponent } from './components/achieved-goals/achieved-goals.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { ExercisetrackingComponent } from './components/exercisetracking/exercisetracking.component';
import { GoalSettingComponent } from './components/goal-setting/goal-setting.component';
import { GoalhomeComponent } from './components/goalhome/goalhome.component';
import { GoaltrackingComponent } from './components/goaltracking/goaltracking.component';
import { HomeComponent } from './components/home/home.component';
import { HtwtcompComponent } from './components/htwtcomp/htwtcomp.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { ListworksComponent } from './components/listworks/listworks.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CustomNutritionRecomendationComponent } from './components/recommendations/custom-nutrition-recomendation/custom-nutrition-recomendation.component';
import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { WorkouthistoryComponent } from './components/workouthistory/workouthistory.component';
import { WorkoutplanComponent } from './components/workoutplan/workoutplan.component';
import { WorksComponent } from './components/works/works.component';
import { guardGuard } from './services/guard.guard';

const routes: Routes = [
  {path:'', redirectTo: 'landingPage', pathMatch: 'full'},
  {path:'register', component: RegistrationComponent},
  {path:'login', component: LoginComponent},
  { path: 'landingPage' , component: LandingPageComponent},
  { path: '',canActivate: [guardGuard],
  children:[
    // { path: 'landingPage' , component: LandingPageComponent},
    { path: 'home', component: HomeComponent },
    { path: 'workout', component: WorkoutplanComponent},
    { path: 'goalhome/goalsetting', component: GoalSettingComponent},
    { path:'goalhome', component : GoalhomeComponent},
    {path : 'goalhome/achievedgoals', component:AchievedGoalsComponent},
    { path: 'recommendations', component: RecommendationsComponent},
    { path: 'history', component: WorkouthistoryComponent},
    {path: 'customRecommendation', component: CustomNutritionRecomendationComponent},
    { path: 'exertracking', component: ExercisetrackingComponent},
    { path: 'exertracking/goaltracking', component: GoaltrackingComponent},
    { path: 'exertracking/heightweighttracking', component: HtwtcompComponent},
    { path: 'profile', component: ProfileComponent},
    { path: 'exertracking/workoutstracking', component: ListworksComponent},
    { path: 'exertracking/workoutstracking/:id', component: WorksComponent},
    {path: 'admin', component: AdminPageComponent}
  ] 
},
{ path: '**', component: ErrorPageComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
