import { createAction, props } from '@ngrx/store';



export const login = createAction(
    '[LoginIdSave] saveId',
    props<{ username: string; password: string }>()
  );