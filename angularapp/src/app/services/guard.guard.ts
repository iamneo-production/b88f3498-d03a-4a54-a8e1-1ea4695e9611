import { CanActivateFn, Router } from '@angular/router';
import { UserAuthService } from './user-auth.service';
import { inject } from '@angular/core';

export const guardGuard: CanActivateFn = (route, state) => {
  const authService = inject(UserAuthService);
  const router = inject(Router);
  var logged!: boolean;

  authService.isUserAuthenticatedSubject.subscribe(is_authenticated => {
    logged = is_authenticated;
  });

  console.log(logged);
  if (logged) {
    return true;
  }
  router.navigate(['login']);
  return false;
};

