import axios from 'axios';
import React, {Component} from 'react';
import './App.css';

class Palindrome extends Component {

    state = {
        checkedValues: [],
        cachedValues: {},
        value: ''
    }

    componentDidMount() {
        this.retrieveValues();
        this.retrieveCachedValues();
    }

    async retrieveValues() {
        const values = await axios.get('/palindrome/check-list');
        this.setState({checkedValues: values.data});
    }

    async retrieveCachedValues() {
        const values = await axios.get('/palindrome/cache/list');
        this.setState({cachedValues: values.data});
    }

    submit = async (event) => {
        event.preventDefault();
        await axios.get('/palindrome/check/' + this.state.value);
        this.setState({value: ''});
    }

    renderCheckedValues() {
        const updatedValues = [];
        for (let index in this.state.checkedValues) {
            updatedValues.push(<li key={index}>{this.state.checkedValues[index]}</li>);
        }
        return (
            updatedValues
        )
    }

    renderCachedValues() {
        const updatedValues = [];
        for (let index in this.state.cachedValues) {
            let key = this.state.cachedValues[index].key;
            let isPalindrome = this.state.cachedValues[index].value === 'true';
            updatedValues.push(<li key={index}>{key} is {isPalindrome ? 'Palindrome' : 'is not Palindrome'}</li>);
        }
        return (
            updatedValues
        )
    }

    render() {
        return (
            <div className="Palindrome">
                <form onSubmit={this.submit}>
                    <label>Enter your value: </label>
                    <input value={this.state.value}
                           onChange={event => this.setState({value: event.target.value})}/>
                    <button type='submit'>Check</button>
                </form>
                <div className="history-div">
                    <h4>Check history:</h4>
                    <div>
                        <ul>
                            {this.renderCheckedValues()}
                        </ul>
                    </div>
                </div>
                <div className="history-div">
                    <h4>Cached check results:</h4>
                    <div>
                        <ul>
                            {this.renderCachedValues()}
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}

export default Palindrome;