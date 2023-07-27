import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { environment } from 'src/environment';

@Component({
  selector: 'app-chatbot',
  templateUrl: './chatbot.component.html',
  styleUrls: ['./chatbot.component.scss'],
  
})
export class ChatbotComponent {
  wantToChat:boolean = false;
  responses: any[] = [];
  resp: any;
  promt!:string;
  isLoading = false;
  api = environment.API_KEY;

  constructor(private http: HttpClient){}

  showChatForm(){
    this.wantToChat = true;
  }

  close(){
    this.wantToChat = false;
  }
  
  async getResponse(message: string){
    this.isLoading = true;
    if(message!='ask'){
      this.promt=message;
    }
    console.log(this.promt);
    const requestOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization':`Bearer ${this.api}`
      }),
    };
    const requestBody = {
      model: 'gpt-3.5-turbo',
      messages: [
        {
          role: 'system',
          content: 'You are a fitness assistant.',
        },
        {
          role: 'user',
          content: this.promt,
        },
      ],
    };
    
    this.http.post<any>('https://api.openai.com/v1/chat/completions', requestBody, requestOptions).subscribe({
      next: (response:any) => {
        let msg = response.choices[0].message.content;
        this.responses.push(msg);
        this.isLoading = false;
        this.promt ="";
      },
      error: (error) => {
        console.error(error);
        this.isLoading = false;
      }
    }); 
  }
}
