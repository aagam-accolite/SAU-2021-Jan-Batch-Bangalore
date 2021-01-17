
import { ApiModuleComponent } from './component/api-module/api-module.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SessionModuleComponent } from './component/session-module/session-module.component';

const routes: Routes = [
  { path: "API", component: ApiModuleComponent },
  { path: "", component:  SessionModuleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
