import { createAction, props } from '@ngrx/store';
import { UserInfo } from 'src/app/vo/user';



export const userinfoTempSave = createAction(
    '[save] save userinfo temporarly',
    props<{payload:UserInfo}>()
  );