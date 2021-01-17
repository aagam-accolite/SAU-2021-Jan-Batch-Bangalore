import { SessionModel } from './../../model/sessionModel';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-session-module',
  templateUrl: './session-module.component.html',
  styleUrls: ['./session-module.component.scss']
})
export class SessionModuleComponent implements OnInit {

  sessions: SessionModel[];

  session_name = "";
  trainer_name = "";
  session_date = new Date();

  edited_session_name = "";
  edited_trainer_name = "";
  edited_session_date = new Date();

  constructor() {
    this.sessions = [
      {
        name: 'Angular',
        trainer: 'Sheldon',
        date: new Date(),
        isDisplay: false,
      },
      {
        name: 'Java',
        trainer: 'Amy',
        date: new Date(),
        isDisplay: false,
      },
      {
        name: 'Spring Boot',
        trainer: 'Raj',
        date: new Date(),
        isDisplay: false,
      }
    ]
  }

  selectedSession: any;
  ngOnInit(): void {
  }

  addSession() {
    const newSession = {
      name: this.session_name,
      trainer: this.trainer_name,
      date: this.session_date
    }
    this.sessions.push(newSession);
    this.session_name = "";
    this.trainer_name = "";
    this.session_date = new Date();
  }

  editSession(id) {
    document.getElementById(id).style.display = 'inline-block';
    document.getElementById('delete').style.display = 'none';
  }

  cancelSelection(id) {
    document.getElementById('delete').style.display = 'inline-block';
    document.getElementById(id).style.display = 'none';
  }

  submitEditedDetails(id) {
    document.getElementById(id).style.display = 'inline-block';
    document.getElementById('delete').style.display = 'inline-block';
    for (let session of this.sessions) {
      if (session.date === id) {
        session.name = this.edited_session_name;
        session.trainer = this.edited_trainer_name;
        session.date = this.edited_session_date;
      }
    }
    this.cancelSelection(id);
  }
  onSelect(session: any) {
    this.selectedSession = session;
    this.selectedSession.isDisplay = true;
    console.log(this.selectedSession);
  }
  deleteSession(id) {
    this.sessions = this.sessions.filter(sessions => sessions.date != id);
  }

}
