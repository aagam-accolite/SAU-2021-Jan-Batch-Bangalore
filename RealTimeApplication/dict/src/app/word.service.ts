import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Word } from './Models/Word';

@Injectable()
export class WordService {

  WORD_ROOT = "word/"
  GET_ALL_WORDs = this.WORD_ROOT + "getAll";
  SAVE_WORD = this.WORD_ROOT + "save";
  DELETE_WORD = this.WORD_ROOT + "delete";
  UPDATE_WORD = this.WORD_ROOT + "update";
  SEARCH_WORD = this.WORD_ROOT + "get";
  constructor(private http: HttpClient) { }
  getAll(): Observable<any> {
    return this.http.get(this.GET_ALL_WORDs);
  }
  addWord(payload: Word): Observable<any> {
    return this.http.post(this.SAVE_WORD, payload);
  }
  deleteWord(id: Number): Observable<any> {
    return this.http.get(this.DELETE_WORD + "/" + id);
  }
  updateWord(payload: Word): Observable<any> {
    return this.http.post(this.UPDATE_WORD, payload);
  }
  matchPattern(pattern: String): Observable<any> {
    return this.http.get(this.SEARCH_WORD + "/" + pattern);
  }
}
