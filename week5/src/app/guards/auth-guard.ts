import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = () => {
  const router = inject(Router);
  const isLoggedIn = true; // hardcoded for now

  if (isLoggedIn) {
    return true;
  }
  router.navigate(['/']);
  return false;
};