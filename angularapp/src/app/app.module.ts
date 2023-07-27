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

import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { ExercisetrackingComponent } from './components/exercisetracking/exercisetracking.component';

import { RecommendationsComponent } from './components/recommendations/recommendations.component';
import { ContainerComponent } from './components/container/container.component';
import { GoalhomeComponent } from './components/goalhome/goalhome.component';
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
import { GoaltrackingComponent } from './components/goaltracking/goaltracking.component';
import { HtwtcompComponent } from './components/htwtcomp/htwtcomp.component';
import { DatetrackingComponent } from './components/datetracking/datetracking.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AchievedGoalsComponent } from './components/achieved-goals/achieved-goals.component';
import {MatIconModule } from '@angular/material/icon';
import { ListworksComponent } from './components/listworks/listworks.component';
import { WorksComponent } from './components/works/works.component';
import { FooterComponent } from './components/footer/footer.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner'
import { ChatbotComponent } from './components/chatbot/chatbot.component';
import { UserAuthService } from './services/user-auth.service';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { MatSnackBar } from '@angular/material/snack-bar';

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
    GoalhomeComponent,
    RegistrationComponent,
    LoginComponent,
    CustomNutritionRecomendationComponent,
    WorkoutplanComponent,
    GoalSettingComponent,
    GoaltrackingComponent,
    HtwtcompComponent,
    DatetrackingComponent,
    ProfileComponent,
    AchievedGoalsComponent,
    ListworksComponent,
    WorksComponent,
    FooterComponent,
    LandingPageComponent,
    ChatbotComponent,
    AdminPageComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatDividerModule,
    MatListModule,
    MatSidenavModule,
    MatToolbarModule,   
    MatMenuModule,
    MatTableModule,
    MatDialogModule,
    AppRoutingModule,
    HttpClientModule,
    MatIconModule,
    MatButtonModule,
    MatProgressSpinnerModule,
  ],

  providers: [DatePipe, UserAuthService, MatSnackBar],
  bootstrap: [AppComponent],
})
export class AppModule {}
