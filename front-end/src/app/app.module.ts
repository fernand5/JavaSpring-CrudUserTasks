import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {UserService} from './_services/user.service';
import {HttpClientModule} from '@angular/common/http';
import {DataTableModule} from 'angular5-data-table';
import { TableComponent } from './table/table.component';
import {AlertService} from './_services/alert.service';
import {FormsModule} from '@angular/forms';
import {TaskService} from './_services/task.service';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    DataTableModule,
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UserService,
    AlertService,
    TaskService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
