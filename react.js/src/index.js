import React, { Component } from 'react';
import ReactDom, { render } from 'react-dom';
import PropTypes from 'prop-types'
import './style.css';

const rootElement = document.getElementById('root')
const appElement = document.getElementById('app')
const domElement = document.getElementById('newDOM')
const validateDOM = document.getElementById('validateDOM')
const functionJS = document.getElementById('functionJS')
const clock = document.getElementById('clock')
const cssBox = document.getElementById('cssBox')
const appOne = document.getElementById('appOne')
const stopWatch = document.getElementById('stopWatch')
const allClass = document.getElementById('allClass')
const basicForm = document.getElementById('basicForm')
const fancyForm = document.getElementById('fancyForm')

//const Child = React.createElement('div', {className: 'New', children:'Basic Reactjs'})
//ReactDom.render(Child, rootElement)


const props1 = {
  className: "jsx",
  children: "basics of jsx"
}

const props2 = {
  className: "jsx1",
  children: "basics of jsx part 1"
}

const element = <div {...props1} {...props2} />
ReactDom.render(element, rootElement)


const aElement = props => <div>{props.arg} of function arguments</div>
const renderElement = (
  <div>
    {aElement({ arg: "Basic" })}
    {aElement({ arg: "Not so basic" })}
  </div>)
ReactDom.render(renderElement, appElement)

// Capitalize the starting letter to treat it as a raw DOM element.
const DElement = props => <div>{props.children}</div>
const renderDElement = (
  <div>
    <DElement>Custom DOM object1</DElement>
    <DElement>Custom DOM object2</DElement>
  </div>
)
ReactDom.render(renderDElement, domElement)


const ValidateDOM = props => <div>{props.firstParameter} {props.SecondParameter}</div>
ValidateDOM.propTypes = {
  firstParameter: PropTypes.string,
  SecondParameter: PropTypes.string
}
const r = (
  <div>
    <ValidateDOM firstParameter="optional parameter1"></ValidateDOM>
    <ValidateDOM SecondParameter="optional parameter2"></ValidateDOM>
  </div>
)

ReactDom.render(r, validateDOM)

function OptionalParm({ message }) {
  return (
    <div>{
      message ? (<div>{message}</div>) : (<div>No Message</div>)
    }
    </div>
  )
}
const rf = (
  <div>
    <OptionalParm message="Reactjs functions"></OptionalParm>
  </div>
)
ReactDom.render(rf, functionJS)

function displayLocalTime() {
  const date = new Date().toLocaleTimeString()
  ReactDom.render(<div>{date}</div>, clock)

}
setInterval(displayLocalTime, 1000)

const boxes = (
  <div className="box box--small" style={{ paddingLeft: 20 }}>box</div>
)
ReactDom.render(boxes, cssBox)


const state = { clicks: 0, userName: '' }

function CoreApp() {
  return (
    <div>
      <p>Your username is {state.userName}</p>
      <button onClick={incrementClick}>submit</button>
      <p>You clicked {state.clicks} times</p>
      <input onChange={args => updateUsername(args.target.value)} />
    </div>
  )
}

function updateUsername(name) {
  updateState({ userName: name })
}
function incrementClick() {
  updateState({ clicks: state.clicks + 1, })
}

function updateState(newState) {
  Object.assign(state, newState)
  renderApp()
}

function renderApp() {
  ReactDom.render(<CoreApp />, appOne)
}
renderApp()


class StopWatch extends React.Component {
  state = { lapse: 0, running: false }

  startHandler = () => {
    this.setState(state => {
      if (this.state.running) {
        clearInterval(this.timer)
      } else {
        const startTime = Date.now() - this.state.lapse
        this.timer = setInterval(() => { this.setState({ lapse: Date.now() - startTime }) })
      }
      return { running: !this.state.running }
    })

  }

  clearHandler = () => {
    this.setState({ lapse: 0, running: false })
  }

  componentWillUnmount = () => {
    clearInterval(this.timer)
  }

  render() {
    return (
      <div>
        <label>{this.state.lapse}ms</label>
        <p>
          <button onClick={this.startHandler}>{this.state.running ? "stop" : "start"}</button>
        </p>
        <button onClick={this.clearHandler}>clear</button>
      </div>
    )
  }
}
ReactDom.render(<StopWatch />, stopWatch)


class Counter extends React.Component {
  // This is not required if its default
  constructor(...args) {
    super(...args)
  }
  state = { counter: 0 }
  onClickHandler = () => {
    this.setState({ counter: this.state.counter + 1 })
  }

  onClearHandler = () => {
    this.setState({ counter: 0 })
  }

  render() {
    return (
      <div>
        <p>{this.state.counter}</p>
        <button onClick={this.onClickHandler}>counter</button>
        <button onClick={this.onClearHandler}>clear</button>
      </div>
    )
  }
}

ReactDom.render(<Counter />, allClass)


class BasicForm extends React.Component {
  state = { error: null }
  onSubmitHandler = (event) => {
    // The default behavior when you submit a form it will refresh the entire page. 
    // The below line will prevent that from happenning.
    event.preventDefault()
    const value = this.inputNode.value
  }

  onInputChange = (event) => {
    // the below statement is quivalent to get the value out of event.target.
    const { value } = event.target
    this.setState({ error: this.props.getErrorMsg(value) })
  }
  componentDidMount = () => {
    this.setState({ error: this.props.getErrorMsg("") })
  }
  render() {
    const { error } = this.state
    return (
      // ref to create a pointer to a DOM node. Which can be used to extract the value.
      <form onSubmit={this.onSubmitHandler}>
        <input type="text" onChange={this.onInputChange} ref={node => this.inputNode = node} />
        <button type="submit" disabled={Boolean(error)}>Submit</button>
      </form>
    )
  }
}

ReactDom.render(<BasicForm
  getErrorMsg={value => {
    if (value.length < 3) {
      return "Its less than 3 chars"
    } else
      return null
  }
  }
/>, basicForm)


class FancyForm extends React.Component {
  state = { commaSep: "", multiLine: "", multiSelect: [] }
  static options = [
    'acura',
    'honda',
    'bmw',
    'mercedes',
    'lexus'
  ]
  commaSepHandler = (event) => {
    const { value } = event.target
    const allVal = value.split(',').map(v => v.trim()).filter(Boolean)
    this.setState({ commaSep: value, multiLine: allVal.join('\n'), multiSelect: allVal.filter(v => FancyForm.options.includes(v)) })
  }
  multiLineHandler = (event) => {
    const { value } = event.target
    const allVal = value.split('\n').map(v => v.trim()).filter(Boolean)
    this.setState({ commaSep: allVal.join(','), multiLine: value, multiSelect: allVal.filter(v => FancyForm.options.includes(v)) })
  }

  multiSelectHandler = (event) => {
    const { selectedOptions } = event.target
    console.log(selectedOptions)
    const allVal = Array.from(selectedOptions).map(v=>v.value)
    console.log('there', Array.from(selectedOptions))
    this.setState({ commaSep: allVal.join(','), multiLine: allVal.join('\n'), multiSelect: allVal })

  }

  render() {
    const { commaSep, multiLine, multiSelect } = this.state
    return (
      <div>
        <p>Comma Separated Values</p>
        <input value={commaSep} onChange={this.commaSepHandler} />
        <p>MultiLine Values</p>
        <textarea value={multiLine} onChange={this.multiLineHandler} />
        <div>
          <label>Mutli Select Values</label>
          <br />
          <select multiple value={multiSelect} onChange={this.multiSelectHandler} size={FancyForm.options.length}>
          {FancyForm.options.map(v => <option key={v} value={v}>{v}</option>)}
          </select>
        </div>
      </div>
    )
  }
}

ReactDom.render(<FancyForm />, fancyForm)
