import { createAction, props } from '@ngrx/store';

export const login = createAction('[Login page] Login',props<{username:string,password:string}>());